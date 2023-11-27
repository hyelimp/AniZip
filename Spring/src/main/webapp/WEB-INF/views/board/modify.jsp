<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<%@include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify(게시글 수정)</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="/board/modify" role="form" method="post">
				
				<!-- Page319 위에 modify.jsp 소스 코딩 시작 : 앞서 get.jsp 소스 재사용 -->
				<input type="hidden" id="pageNum" name="pageNum" value="<c:out value="${cri.pageNum}" />">
				<input type="hidden" id="amount" name="amount" value="<c:out value="${cri.amount}" />">
				<input type="hidden" name="type" value="<c:out value="${cri.type}" />">
				<input type="hidden" name="keyword" value="<c:out value="${cri.keyword}" />" />
				<!-- Page319 위에 modify.jsp 소스 코딩 끝 : 앞서 get.jsp 소스 재사용 -->	
				
				
					<div class="form-group">
						<label>Bno</label>
						<input class="form-control" name="bno" value='<c:out value="${board.bno}" />' readonly="readonly">					
					</div>		
					
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title" value='<c:out value="${board.title}" />' >					
					</div>		
					
					<div class="form-group">
						<label>Text area</label>
						<textarea rows="3" class="form-control" name="content" ><c:out value="${board.content}" /></textarea>					
					</div>
					
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer" value='<c:out value="${board.writer}" />' readonly="readonly">					
					</div>
					
					<div class="form-group">
						<label>RegDate</label>
						<input class="form-control" name="regdate" value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.regdate}" />' readonly="readonly">					
					</div>
					
					<div class="form-group">
						<label>Update Date</label>
						<input class="form-control" name="updateDate" value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.updateDate}" />' readonly="readonly">					
					</div>
					
					<button data-oper='modify' class="btn btn-default" onclick="location.href='/board/modify?bno=<c:out value="${board.bno}" /> '">글내용 수정(Modify)</button>	
					<button type="submit" data-oper='remove' class="btn btn-danger">글내용 삭제(Remove)</button>
					<button data-oper='list' class="btn btn-info" onclick="location.href='/board/list'">글목록보기(List)</button>					
					</form>
					
			</div> <!-- end panel-body -->
		</div> <!-- end panel -->
	</div> <!-- end col-lg-12 -->
</div> <!-- end row -->

<script type="text/javascript">

	$(document).ready(function() {
		var formObj = $("form");
		
		$('button').on("click", function(e) {
			// form 태그의 모든 버튼은 기본적으로 submit으로 처리하기 때문에
			// e.preventDefault()로 기본 동작을 막고 마지막에 직접 submit()을 수행합니다.
			e.preventDefault();
			// 자바스크립트에서는 button 태그의 'data-oper' 속성을 이용해서
			// 원하는 기능을 동작하도록 처리합니다.
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if (operation === 'remove') {
				formObj.attr("action", "/board/remove");
			} else if (operation === 'list') {
				// move to list
				// 수정된 내용은 클릭한 버튼이 List인 경우 action 속성과 method 속성을
				// 변경합니다. '/board/list'로의 이동은 아무런 파라미터가 없기 때문에
				// form 태그의 모든 내용은 삭제한 상태에서 submit()을 진행합니다.		
				formObj.attr("action", "/board/list").attr("method", "get");
				
				// Page 321 수정/삭제 페이지에서 목록 페이지로 이동 처리
				// 페이지 이동의 마지막은 수정/삭제를 취소하고 다시 목록 페이지로 이동하는 것입니다.
				// 목록 페이지는 오직 pageNum과 amount만을 사용하므로 form 태그의
				// 다른 내용들은 삭제하고 필요한 내용만을 다시 추가하는 형태가 편리합니다.
				// 만일 사용자가 'List' 버튼을 클릭한다면 form 태그에서 필요한 부분만 잠시
				// 복사(clone)해서 보관해 두고, form 태그 내의 모든 내용은 지워버립니다(empty)
				// 이후에 다시 필요한 태그들만 추가해서 '/board/list'를 호출하는 형태를 이용합니다.
					// Page 321 자바스크립트 소스 추가 시작				
					var pageNumTag = $("input[name='pageNum']").clone();
					var amountTag = $("input[name='amount']").clone();
					var keywordTag = $("input[name='keyword']").clone();
					var typeTag = $("input[name='type']").clone();
					// Page 321 자바스크립트 소스 추가 끝
				formObj.empty();
				// Page 321 자바스크립트 소스 추가 시작
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
				// Page 321 자바스크립트 소스 추가 끝
			}
			formObj.submit();
		});
	});

</script>

<%@include file="../includes/footer.jsp" %>


