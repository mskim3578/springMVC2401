<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modal Example</title>
<style>
  /* 모달 스타일 */
  .modal {
    display: none; /* 모달 초기에는 숨김 */
    position: fixed; 
    z-index: 1; /* 다른 요소 위에 위치 */
    left: 0;
    top: 0;
    width: 100%; 
    height: 100%; 
    overflow: auto; 
    background-color: rgba(0,0,0,0.4); /* 배경 어둡게 */
    padding-top: 60px; 
  }

  /* 모달 내용 스타일 */
  .modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
  }

  /* 닫기 버튼 스타일 */
  .close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
  }

  .close:hover,
  .close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
  }
</style>
</head>
<body>

<!-- 모달 버튼 -->
<button id="openModalBtn">Open Modal</button>

<!-- 모달 -->
<div id="myModal" class="modal">
  <!-- 모달 내용 -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <p>모달 내용을 입력하세요.</p>
  </div>
</div>

<script>
// 모달 관련 JavaScript
// 모달 열기 버튼 클릭 시
document.getElementById('openModalBtn').addEventListener('click', function() {
  document.getElementById('myModal').style.display = 'block';
});

// 모달 닫기 버튼 클릭 시
document.getElementsByClassName('close')[0].addEventListener('click', function() {
  document.getElementById('myModal').style.display = 'none';
});

// 모달 외부 클릭 시 닫기
window.addEventListener('click', function(event) {
  if (event.target == document.getElementById('myModal')) {
    document.getElementById('myModal').style.display = 'none';
  }
});
</script>

</body>
</html>
