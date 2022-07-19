const cusIDRegEx = /^(C-)[0-9]{5}$/;
const cusNameRegEx = /^[A-z ]{2,20}$/;
const cusAddressRegEx = /^[0-9/A-z. ,]{5,}$/;
const cusContactRegEx = /^(0)[0-9]{2}(-)[0-9]{7}$/;

let btnCusSearch = $("#btnCustSearch");
let btnCusSave = $("#btnCustSave");
let btnCusUpdate = $("#btnCustUpdate");
let btnCusDelete = $("#btnCustDelete");

let txtCusSearch = $("#txtCusSearch");
let txtCusID = $("#txtCusID");
let txtCusName = $("#txtCusName");
let txtCusAddress = $("#txtCusAddress");
let txtCusContact = $("#txtCusContact");

let cmbOrderCusId = $("#cmbOrderCustId");
let tblCustomer = $("#customer-table");

const customer_base_url = "http://localhost:8080/Backend/customer/";

txtCusID.keyup(function (event) {
    validateCustId();
    if (event.key === 'Enter' && cusIDRegEx.test(txtCusID.val())){
        txtCusName.focus();
    }
});
txtCusName.keyup(function (event) {
    validateCustName();
    if (event.key === 'Enter' && cusNameRegEx.test(txtCusName.val())){
        txtCusAddress.focus();
    }
});
txtCusAddress.keyup(function (event) {
    validateCustAddress();
    if (event.key === 'Enter' && cusAddressRegEx.test(txtCusAddress.val())){
        txtCusContact.focus();
    }
});
txtCusContact.keyup(function (event) {
    validateCustContact();
});



$(document).ready(function() {
    loadAllCustomers();
    //loadFromCustomerTable();
    setCustomerCombo();
});

btnCusSearch.click(function () {
    clearAllCustomerFields();

    $.ajax({
        url:customer_base_url+txtCusSearch.val(),
        method:"GET",
        dataType:"json",
        success:function (jsonResp) {
            if(jsonResp.status===200){
                loadCustomerToFields(jsonResp.data);
            }else if(jsonResp.status===500){
                alert(jsonResp.message);
            }else{
                alert(jsonResp.data);
            }
        },
        error:function (ob){
            alert(ob.responseJSON.message);
        }
    });

    function loadCustomerToFields(data) {
        txtCusID.val(data.id);
        txtCusName.val(data.name);
        txtCusAddress.val(data.address);
        txtCusContact.val(data.contact);

        validateCustId();
        validateCustName();
        validateCustAddress();
        validateCustContact();
    }

    //loadFromCustomerTable();

});

btnCusSave.click(function () {

    let jsonReq = {id: txtCusID.val(),name: txtCusName.val(),address: txtCusAddress.val(),contact: txtCusContact.val()};

    $.ajax({
        url:customer_base_url,
        method:"POST",
        contentType:"application/json",
        data:JSON.stringify(jsonReq),
        success:function (jsonResp) {
            if(jsonResp.status===200){
                alert(jsonResp.message);
                loadAllCustomers();
                clearAllCustomerFields();
                setCustomerCombo();
            }else if(jsonResp.status===500){
                alert(jsonResp.message);
            }else{
                alert(jsonResp.data);
            }
        },
        error:function (ob){
            alert(ob.responseJSON.message);
        }
    });

    //loadFromCustomerTable();

});

btnCusUpdate.click(function () {

    let jsonReq = {id: txtCusID.val(),name: txtCusName.val(),address: txtCusAddress.val(),contact: txtCusContact.val()};

    $.ajax({
        url:customer_base_url,
        method:"PUT",
        contentType:"application/json",
        data:JSON.stringify(jsonReq),
        success:function (jsonResp) {
            if(jsonResp.status===200){
                alert(jsonResp.message);
                loadAllCustomers();
                clearAllCustomerFields();
                setCustomerCombo();
            }else if(jsonResp.status===500){
                alert(jsonResp.message);
            }else{
                alert(jsonResp.data);
            }
        },
        error:function (ob){
            alert(ob.responseJSON.message);
        }
    });

    //loadFromCustomerTable();

});

btnCusDelete.click(function () {

    $.ajax({
        url:customer_base_url+txtCusID.val(),
        method:"DELETE",
        contentType:"application/json",
        success:function (jsonResp) {
            if(jsonResp.status===200){
                alert(jsonResp.message);
                loadAllCustomers();
                clearAllCustomerFields();
                setCustomerCombo();
            }else if(jsonResp.status===500){
                alert(jsonResp.message);
            }else{
                alert(jsonResp.data);
            }
        },
        error:function (ob){
            alert(ob.responseJSON.message);
        }
    });

    //loadFromCustomerTable();

});

function loadFromCustomerTable() {

    $("#customer-table>tr:not(.spacer)").click(function () {
        let id = $(this).children(":eq(1)").text();
        let name = $(this).children(":eq(2)").text();
        let address = $(this).children(":eq(3)").text();
        let contact = $(this).children(":eq(4)").text();

        console.log(id, name, address, contact);

        txtCusID.val(id);
        txtCusName.val(name);
        txtCusAddress.val(address);
        txtCusContact.val(contact);

        validateCustId();
        validateCustName();
        validateCustAddress();
        validateCustContact();
    });
}

function setCustomerCombo() {
    cmbOrderCusId.empty();
    cmbOrderCusId.append(new Option("Customer ID", ""));

    $.ajax({
        url:customer_base_url+"ids",
        method:"GET",
        contentType:"application/json",
        success:function (jsonResp) {
            if(jsonResp.status===200){
                for (let i=0; i<jsonResp.data.length; i++) {
                    let id=jsonResp.data[i];
                    cmbOrderCusId.append(new Option(id, id));
                }
            }else if(jsonResp.status===500){
                alert(jsonResp.message);
            }else{
                alert(jsonResp.data);
            }
        },
        error:function (ob){
            alert(ob.responseJSON.message);
        }
    });

}

function clearAllCustomerFields() {
    txtCusID.val('');
    txtCusName.val('');
    txtCusAddress.val('');
    txtCusContact.val('');

    txtCusID.css('border','1px solid #ced4da');
    txtCusName.css('border','1px solid #ced4da');
    txtCusAddress.css('border','1px solid #ced4da');
    txtCusContact.css('border','1px solid #ced4da');
}

function loadAllCustomers() {

    $.ajax({
        url:customer_base_url,
        method:"GET",
        contentType:"application/json",
        success:function (jsonResp) {
            if(jsonResp.status===200){
                loadCustomerTable(jsonResp.data);
            }else if(jsonResp.status===500){
                alert(jsonResp.message);
            }else{
                alert(jsonResp.data);
            }
        },
        error:function (ob) {
            alert(ob.responseJSON.message);
        }
    });

    function loadCustomerTable(data) {
        tblCustomer.empty();

        for (let i=0; i<data.length; i++){
            let id=data[i].id;
            let name=data[i].name;
            let address=data[i].address;
            let contact=data[i].contact;

            let row = `<tr scope="row"><td>${i+1}</td><td><a href="#">${id}</a></td><td>${name}</td><td>${address}</td><td>${contact}</td></tr><tr class="spacer"><td colspan="100"></td></tr>`;
            tblCustomer.append(row);
        }
    }
}

function validateCustId(){
    if (cusIDRegEx.test(txtCusID.val())) {
        txtCusID.css('border','3px solid green');
    }else{
        txtCusID.css('border','3px solid red');
    }
}
function validateCustName(){
    if (cusNameRegEx.test(txtCusName.val())) {
        txtCusName.css('border','3px solid green');
    }else{
        txtCusName.css('border','3px solid red');
    }
}
function validateCustAddress(){
    if (cusAddressRegEx.test(txtCusAddress.val())) {
        txtCusAddress.css('border','3px solid green');
    }else{
        txtCusAddress.css('border','3px solid red');
    }
}
function validateCustContact(){
    if (cusContactRegEx.test(txtCusContact.val())) {
        txtCusContact.css('border','3px solid green');
    }else{
        txtCusContact.css('border','3px solid red');
    }
}