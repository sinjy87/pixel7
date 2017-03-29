<%@ page contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#blah {
	margin-top: 50px;
	width: 600px;
	height: 600px;
}

.filebox input { /* 파일 필드 숨기기 */
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0; 
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

.filebox label {
	display: inline-block;
	padding: .5em .75em;
	color: #999;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #fdfdfd;
	cursor: pointer;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
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

	function input(f) {
		if (f.fileMF.value == "") {
			alert("사진을 등록하세요");
			f.fileMF.focus();
			return false;
		}
	}
</script>

</head>

<body>

	<FORM name='frm' method='POST' action='./create'
		onsubmit="return input(this)" enctype="multipart/form-data">


		<table style="margin: auto;">
		<tr>
			<td rowspan="7">
				<div class="filebox">
					<form id="form1" runat="server">
						<img id="blah" /> <br> <label for="imgInp">Photo</label>
						<input class="w3-input w3-padding-16 w3-border" type='file'
						    required name="fileMF" id="imgInp" name="fileMF" accept=".jpg" />
					</form>

						<label  for="upload" style="position:relative; left: 650px; ">Upload</label> 
						<input class="w3-button w3-light-grey w3-padding-large" type="submit"	id="upload"></input> 
						
						<label for="reset" style="position:relative; left: 680px;">reset</label> 
						<input	type="reset" id="reset"> 
						
						<label for="back" style="position:relative; left: 710px;">Back</label>
						<input	type="button" onclick="history.back()" id="back">
					</div>
			</td>
		</tr>


			<tr>
				<td>
					<input class="w3-input w3-padding-16 w3-border" type="text"
						placeholder="Content" required name="img_content"
						name="img_content" size="60">
				</td>
			</tr>

			<tr>
				<td>
						<input class="w3-input w3-padding-16 w3-border" type="text"
							placeholder="Category" required name="img_category"
							name="img_category" >
				</td>
			</tr>

			<tr>
				<td>
						<input class="w3-input w3-padding-16 w3-border" type="text"
							placeholder="Price" required name="img_price" name="img_price"
							size="40">
				</td>
			</tr>




		</TABLE>



	</FORM>

</body>
</html>
