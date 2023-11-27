<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board(게시판)</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List Page
				<button id="regBtn" type="button" class="btn btn-xs pull-right">Register
					New Board</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<!-- Model에 담긴 데이터 출력 : '/board/list'를
                                                                      실행했을 때 앞서 BoardController는 Model을 이용해서
                                                                      게시물의 목록을 'list'라는 이름으로 담아서 전달했으므로
                                     list.jsp에서는 이것을 출력합니다.
                                                                       출력은 JSTL을 이용해서 처리합니다.-->
					<c:forEach items="${list}" var="board">
						<tr>
							<td><c:out value="${board.bno}"></c:out></td>
							
							<!-- a 태그에 target="_blank" 속성을 적용하면 새창으로 글 상세 내용을 보여줌 -->							
							<!-- Page314 소스 코딩할 때, 아래 2줄 소스는 주석 처리를 합니다! -->
							<!-- 
							<td><a href='/board/get?bno=<c:out value="${board.bno}"  />'><c:out
										value="${board.title}" /></a></td>
							-->
							<!-- Page314 : 이벤트 처리를 위한 a 태그에 class 속성 move를 적용해 줍니다. -->
							<!-- Page486 views 폴더 내 board/list.jsp 파일의 일부에 댓글의 숫자 표시를 반영해 줍니다. -->
							<td><a class="move" href='<c:out value="${board.bno}"/>'><c:out value="${board.title}"/><b> [<c:out value="${board.replyCnt}"/>]</b></a></td>
							<td><c:out value="${board.writer}"></c:out></td>
							<td><fmt:formatDate value="${board.regdate}"
									pattern="yyyy-MM-dd" />
							<td><fmt:formatDate value="${board.updateDate}"
									pattern="yyyy-MM-dd" />
						</tr>

					</c:forEach>

				</table>
				<!-- /.table-responsive -->
				
				
				<div class="row">
					<div class="col-lg-12">
						<form action="/board/list" id="searchForm" method="get">
							<select name="type">
								<option value=""
									<c:out value="${pageMaker.cri.type == null?'selected':''}" />>&lt;검색 조건 선택&gt;</option>
								<option value="T"
									<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}" />>제목</option>
								<option value="C"
									<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}" />>내용</option>
								<option value="W"
									<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}" />>작성자</option>								
									
								<option value="TC"
									<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}" />>제목 or 내용</option>
								<option value="TW"
									<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}" />>제목 or 작성자</option>
								<option value="TWC"
								<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}" />>제목 or 내용 or 작성자</option>
							</select>
							<input type="text" name="keyword" value="<c:out value="${pageMaker.cri.keyword}"/>"/>
							<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
							<input type="hidden" name="amount" value="${pageMaker.cri.amount}">							
							<button class="btn btn-default">검색(Search)</button>
						</form>					
							<button data-oper='list' class="btn btn-info" onclick="location.href='/board/list'">글목록보기(List)</button>
					</div>				
				</div>

				<!-- Page308 pagination 붙여넣기 적용 후에 Ctrl + Shift + F 클릭 적용해 줌 -->
				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous"><a href="${ pageMaker.startPage -1}">Previous</a></li>
						</c:if>
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="paginate_button"><a href="${num}">${num}</a></li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a href="${ pageMaker.endPage +1}">Next</a></li>
						</c:if>				
					</ul>
				</div> <!-- end Pagination -->
				
				<!-- Page311 : 실제 페이지를 클릭하면 동작을 하는 부분은 별도의 form 태그를 이용해서 처리하도록 합니다! -->
				<form action="/board/list" id="actionForm" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
					<input type="hidden" name="type" value="<c:out value="${pageMaker.cri.type}" />">
					<input type="hidden" name="keyword" value="<c:out value="${pageMaker.cri.keyword}"/>"/>
					
					
				</form>

				<!-- Modal 추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">처리 알림!</h4>
							</div>
							<div class="modal-body">처리가 완료 되었습니다!</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	// 새로운 게시물의 번호는 BoardController의 addFlashAttribute() 메서드로
	// 저장되었기 때문에 한 번도 사용된 적이 없다면 사용자가 "/board/list"를 호출하거나,
	// '새로고침'을 통해서 호출하는 경우 아무런 내용이 없게 됩니다.
	// 또한, addFlashAttribute() 메서드를 이용해서 일회성으로만 데이터를 사용할 수 
	// 있으므로 이를 이용하여 경고창이나 모달창 등을 보여주는 방식으로 처리할 수 있습니다.
	$(document).ready(
			function() {
				var result = '<c:out value="${result}" />';

				// 모달창 관련 자바스크립트 소스 코딩(시작)	
				// checkModal() 함수는 파라미터에 따라서 모달창을 보여주거나 내용을 수정한 뒤
				// 보이도록 처리합니다. checkModal()에서는 새로운 게시글이 작성되는 경우
				// RedirectAttributes로 게시물의 번호가 전송되므로 이를 이용해서 모달창의 내용을
				// 수정 처리합니다. $("#modal").modal('show')를 호출하면 모달창이 보이게 됩니다.
				// 실행 확인은 웹 프로젝트 실행 후 '/board/register'를 이용해서 새로운 게시물을 작성하고
				// 나면 자동으로 '/board/list'로 이동하면서 모달창이 보이게 됩니다.		
				checkModal(result);

				history.replaceState({}, null, null);

				function checkModal(result) {
					if (result === '') {
						return;
					}

					if (parseInt(result) > 0) {
						$(".modal-body").html(
								"게시글 " + parseInt(result) + " 번이 등록되었습니다!");
					}
					$("#myModal").modal("show");
				}
				// 모달창 관련 자바스크립트 소스 코딩(종료)

				// list.jsp에서  Register New Board 버튼 클릭하면
				// 게시물의 등록 웹페이지로 이동 처리 합니다.
				$("#regBtn").on("click", function() {
					self.location = "/board/register";
				});
				
				// Page312 a 태그가 원래의 동작을 못하도록 JavaScript 처리를 합니다.
				var actionForm = $("#actionForm");
				
				$(".paginate_button a").on("click", function(e) {
					
					e.preventDefault();
					
					console.log('click');
					
					actionForm.find("input[name='pageNum']").val($(this).attr("href"));
					actionForm.submit();
				});
				
				// Page315 : list.jsp 게시물 조회를 위한 이벤트 처리 추가
				$(".move").on("click", function(e) {
					e.preventDefault();
					actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
					actionForm.attr("action", "/board/get");
					actionForm.submit();
				});
				
				// Page342 자바스크립트 소스 코딩 시작
				var searchForm = $("#searchForm");
				
				$("#searchForm button").on("click", function(e) {
					if(!searchForm.find("option:selected").val()){
						alert("검색 종류를 선택해 주시기 바랍니다!");
						return false;
					}
					
					if(!searchForm.find("input[name='keyword']").val()){
						alert("키워드를 입력해 주시기 바랍니다!");
						return false;						
					}
					
					// 여러 종류들 중에서 검색 버튼을 클릭하면
					// 기본 검색 결과 페이지는 1페이지가 되도록 수정 처리합니다.
					searchForm.find("input[name='pageNum']").val("1");
					// 브라우저에서 검색 버튼을 클릭하면 form 태그의 전송은 막고,
					// 페이지의 번호는 1이 되도록 처리 합니다.
					// 화면에서 키워드가 없다면 검색을 하지 않도록 제어합니다.
					e.preventDefault();
					searchForm.submit();
				});				
				// Page342 자바스크립트 소스 코딩 끝
			});
</script>

<%@include file="../includes/footer.jsp"%>

