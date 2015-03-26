function liste_jeux(id){
	var tab_jeux;
	$.ajax({
		url:"http://localhost:8080/v1/jeudb",
		data:{},
		type:"GET",
		dataType:"json",
		async: false,
		success:function(a){
			tab_jeux = a;
		},
		error:function(){}
	});
	var regex = new RegExp(' ','g');
	for(var len = tab_jeux.length - 1; len >= 0; len --){
		$("#"+id).append("<li><a href=\"" + tab_jeux[len].nom.replace(regex, '') + ".html\">" + tab_jeux[len].nom + "</a></li>");
	}
}

function getListJeu(){
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
	return tab_jeux;
}

function isConnected(){
	var id = readCookie("id");
	var ret = true;
	try{
		$.ajax({
			url:"http://localhost:8080/v1/joueurdb/" + id,
			data:{},
			type:"GET",
			dataType:"json",
			async:false,
			success:function(a){
				ret = true;
			},
			error : function(jqXHR, textStatus, errorThrown) { 
    			if(jqXHR.status == 404 || errorThrown == 'Not Found'){ 
        		ret = false ;
    			}
			}
		});
	}catch(e){
		ret = false;
	}
	if(readCookie("id") === null){
				document.location.href="index.html";
	}else{
		if(ret === false){
			document.location.href="index.html";
		}
	}
}
