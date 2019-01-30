/**
 * 调用后台批量删除方法
 */
function DeleteBatch(basePath) {
	$("#mainForm").attr("action", basePath + "DeleteBatchServlet.action");
	$("#mainForm").submit();
}
/**
 * 调用后台新增方法
 */
function CreateOne(basePath) {
	if (document.getElementById("command").value == "") {
		alert("请输入指令");
		
	} else if (document.getElementById("description").value == "") {
		alert("请输入描述");
	
	} else if (document.getElementById("content").value == "") {
		alert("请输入内容");
		
	} else {
		alert("成功");			
	}
	/*$("#mainForm").attr("action", basePath + "CreateOneServlet.action");
	$("#mainForm").submit();*/

}