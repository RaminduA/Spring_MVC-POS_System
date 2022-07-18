let dashboardContent = $("#dashboardContent");
let customerContent = $("#customerContent");
let itemContent = $("#itemContent");
let placeOrderContent = $("#placeOrderContent");

let linkHome = $("#linkHome");
let linkCustomer = $("#linkCustomer");
let linkItem = $("#linkItem");
let linkPlaceOrder = $("#linkPlaceOrder");
let linkLogo = $("#linkLogo");

let preloader = $("#js-preloader");


$(document).ready(function() {
    preloader.fadeOut(2000);
    displayActiveContent(dashboardContent);
});


linkHome.click(function (){
    displayActiveContent(dashboardContent);
    focusActiveLink(linkHome);
});

linkLogo.click(function (){
    displayActiveContent(dashboardContent);
    focusActiveLink(linkHome);
});

linkCustomer.click(function (){
    displayActiveContent(customerContent);
    focusActiveLink(linkCustomer);
});

linkItem.click(function (){
    displayActiveContent(itemContent);
    focusActiveLink(linkItem);
});

linkPlaceOrder.click(function (){
    displayActiveContent(placeOrderContent);
    focusActiveLink(linkPlaceOrder);
});

function displayActiveContent(activeContent) {
    dashboardContent.css("display","none");
    customerContent.css("display","none");
    itemContent.css("display","none");
    placeOrderContent.css("display","none");
    activeContent.css("display","block");
}

function focusActiveLink(activeLink) {
    linkHome.removeClass("active");
    linkCustomer.removeClass("active");
    linkItem.removeClass("active");
    linkPlaceOrder.removeClass("active");
    activeLink.addClass("active");
}