function liste_jeux(id){
	var tab_jeux;
	$.ajax({
		url:"http://localhost:8080/v1/jeudb",
		data:{},
		type:"GET",
		dataType:"json",
		async: false,
		success:function(a){
			console.log(a);
			tab_jeux = a;
		},
		error:function(){}
	});
	var regex = new RegExp(' ','g');
	for(var len = tab_jeux.length - 1; len >= 0; len --){
		$("#"+id).append("<li><a href=\"" + tab_jeux[len].nom.replace(regex, '') + "\">" + tab_jeux[len].nom + "</a></li>");
	}
}
