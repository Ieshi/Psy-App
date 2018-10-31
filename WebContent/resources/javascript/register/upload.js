$(function(){
	$("input[type='file']").on('change',function(){
		var fileName = $(this).val();
        $(this).next('.custom-file-label').html(fileName);
	});
});