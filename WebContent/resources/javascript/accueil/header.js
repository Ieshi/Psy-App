$(function(){
    $(window).scroll(function() {
        var scroll = getCurrentScroll();
        if ( scroll >= 300 ) $('header').addClass('scroll');
        else $('header').removeClass('scroll');
    });

    var getCurrentScroll = function() {
        return window.pageYOffset || document.documentElement.scrollTop;
    }
});

$(function(){
    for(var i=0 ; i< 850; i++)
        $('.w').prepend('<div class="i"></div>');
})