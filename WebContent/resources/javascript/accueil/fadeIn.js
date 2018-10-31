$(function() {
    $(window).scroll( function(){
        $('.fadeIn').each( function(i){
            var bottom_of_window = $(window).scrollTop() + $(window).height();
            if( bottom_of_window > $(this).position().top )
                $(this).animate({'opacity':'1'}, 1200);
        }); 
    });  
});