$(document).ready(function() {
    $(window).bind('scroll', function(e) {
        parallax();
    });
});

function parallax() {
    var scrollPosition = $(window).scrollTop();
    $('#tb-imagebg').css('top',(0 - (scrollPosition * .2))+'px' );
}       