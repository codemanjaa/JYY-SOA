window.onload = customize;

function customize(){
	window.document.getElementById('div3').style.display = 'none';
}

function getCardInfo()
{
	window.document.getElementById('div3').style.display = 'none';
	var q_str = 'type=card&value='+document.getElementById('t1').value;
	doAjax('MyCardValidator_Servlet',q_str,'displayInfo','post',0);
}

function getIpInfo()
{
	window.document.getElementById('div3').style.display = 'none';
	var q_str = 'type=ip&value='+document.getElementById('iptext').value;
	doAjax('MyIpConvertor_Servlet',q_str,'displayInfo','post',0);
}

function getCheck(){
	var q_str = 'type=ip&value='+document.getElementById('iptext').value+'&card='+document.getElementById('t1').value;
	doAjax('MyCardAllowedValidator_Servlet',q_str,'displayInfo','post',0);
	
}

function displayInfo(result)
{
	if (result.substring(0,5)=='error'){
	   window.document.getElementById('div3').style.display = 'block';
	   window.document.getElementById('div3').innerHTML="<p style='color:red;'><b>"+result.substring(6)+"</b></p>";
   }else{
	   window.document.getElementById('t4').value=""+result;
   }
}

