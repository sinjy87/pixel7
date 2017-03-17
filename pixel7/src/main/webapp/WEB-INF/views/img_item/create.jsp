<%@ page contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#blah{
margin-top: 20px;
width: 600px;
height:  600px;
}

</style>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#imgInp").on('change', function() {
			readURL(this);
		});
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

</script>

</head>

<body>

	<FORM name='frm' method='POST' action='./create'
		enctype="multipart/form-data">
		
		<table>
			<form id="form1" runat="server">
				<img id="blah"/>
				<input type='file' id="imgInp"  name = "fileMF" accept=".jpg"/> 
			</form>
		</table>
		
		<TABLE>
			<TR>
				<TH>내용</TH>
				<TD><textarea rows="10" cols="50" name="img_content"></textarea></TD>
			</TR>
			<tr>
			<th>Category</th>
			<td>
<!-- 			<button name="img_category" value="human">Human</button> -->
			<input type="button" value = "Human" > 
							<TD><input id="Human" type="text" name="img_category"/></TD>
			
			</td>  
			</tr>
			
			<TR>
				<TH>Price</TH>
				<TD><input type="text" name="img_price"/></TD>
			</TR>

			
		</TABLE>

		<DIV class='bottom'>
			<input type='submit' value='등록'> <input type="reset"
				value='재입력'> <input type="button" value='취소'
				onclick="history.back()">
		</DIV>
	</FORM>

</body>
</html>
