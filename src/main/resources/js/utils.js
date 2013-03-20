/**
 * 
 * @param idName
 * @author Luigi Porritiello.
 */ 
function setRequired(idName,message) {

    	  try{
        	  var idForm = 'form:';
        	  var idReq = idForm+idName;
        	  var idMsg = idForm + 'message';
        	  var popMess = document.getElementById(idMsg);
        	  var it = document.getElementById(idForm+idName);
        	 
        	  var top = Math.round(it.getBoundingClientRect().top - 18 );
        	  var left = Math.round(it.getBoundingClientRect().left + 8);

        	  var spanErr = createSpanElement();
        	  var spanDetail = createSpanElement();

        	  
        	  if(!it.value){
        		  setBorderRed(idReq);
        		  setPosition(popMess, top, left);
        		  showMsgValidator(idMsg, spanErr, spanDetail, message);
        	 
        	  }else{
        		  	resetBorder(idReq);
        		  	hideMsgValidator(idMsg);
            	  }
        	  }catch (e) {
  				alert(e);
  			}
      }

/**
 * 
 * @param component
 * @param top
 * @param left
 */
function setPosition(component,top,left){
	try{
		component.style.top = top+'px';
		component.style.left = left+'px';
	}catch (e) {
		alert(e);
	}
}
 
 
/**
 * 
 * @returns
 */
 function createSpanElement(){
	 
	 var span = document.createElement('span');
	 
	 return span;
 }
 
 
 /**
  * 
  * @param id
  * @author Luigi Porritiello.
  */
 function setBorderRed(id){
	 var component = document.getElementById(id);
	 
	 component.style.border='solid 2px';
	 component.style.borderColor='red';
	 
 }
 
 /**
  * 
  * @param id
  */
 function resetBorder(id){
	 var component = document.getElementById(id);
	 
	 component.style.border=null;
	 component.style.borderColor=null;
 }
 
 /**
  * 
  * @param idMsg
  * @param spanErr
  * @param spanDetail
  * @param message
  * @author Luigi Porritiello.
  */
 function showMsgValidator(idMsg,spanErr,spanDetail,message){
	 var popup = document.getElementById(idMsg);
	 
	 if(!popup.childNodes.length > 0){
	 	spanDetail.innerHTML = message;
   	  	spanDetail.className = 'rf-msg-det'; 	  
   	  	spanErr.className ='rf-msg-err';
 	  	spanErr.appendChild(spanDetail);
 	  	popup.appendChild(spanErr);
	 }
	 
	 popup.style.visibility='visible';
 }
 
 /**
  * 
  * @param popup
  * @author Luigi Porritiello.
  */
 function hideMsgValidator(idMsg){
	 var popup = document.getElementById(idMsg);
	 popup.style.visibility='hidden';
 }
 