

$(document).ready(function() {

    $('.linkProductView').mouseover(function () {
        var productName = $(this).parent().next().children(".view-cart-product-name").text()
        $(".linkProductView").attr("href","/product?productName="+productName+"")

    })

});


        $('.checkout').click(function(){

            $('.allSite').css({
                "opacity": "0.1",
                "z-index": "-1",
            
            })
            
            $('.checkout-list').show();
            });



            $('.close-checkout').click(function(){

                $('.allSite').css({
                    "opacity": "1",
                    "z-index": "0",
                
                })
                
                $('.checkout-list').hide();
                
                
                });
                
                
                
                $('.button-got-it').click(function(){
                
                $('.allSite').css({
                    "opacity": "1",
                    "z-index": "0",
                
                })
                
                $('.checkout-list').hide();
                
                
                });
                