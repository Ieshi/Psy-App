$(function(){
	$('.card').on('hidden.bs.collapse', function(){
	    $(this).find('.fas').removeClass('fa-plus-circle').addClass('fa-minus-circle');
	});
	$('.card').on('show.bs.collapse', function(){
		$(this).find('.fas').removeClass('fa-minus-circle').addClass('fa-plus-circle');
	});
})