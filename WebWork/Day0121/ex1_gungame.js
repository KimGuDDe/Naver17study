$(function(){
    /*
    총을 클릭 시 0부터 11 사이의 난수 발생 후 해당번째 인형을 사라지게 하기
    이미 사라진 경우는 메세지
    */
   $(".gun").click(function(){
    //0~11 사이 난수 발생
    let idx=parseInt(Math.random()*12);

    if($(".sunban img").eq(idx).is(":hidden")){

        $("#msg").html("꽝!!!!!꽈아아아아앙!!"+(idx+1)+"번째 인형은 없습니다");
    }else{
        $("#msg").html((idx+1)+"번째 인형을 맞췄습니다");
        // $(".sunban img").eq(idx).fadeOut('fast');
        $(".sunban img").eq(idx).hide();
    }

    //hidden 갯수 12이면 게임 끝
    let n=$(".sunban img:hidden").length;
    if(n==12){
        $("#msg").html("GAME OVER!!");
    }
   });
   //돈 클릭 시 돈은 사라지고 나머지 모두 초기화
   $(".money img").click(function(){
    $(".sunban img").show();
    $("#msg").html("");

    // $(this).css("visibility","hidden"); //사라져도 자리 자치
    $(this).css("display","none"); //사라지면 자리 내줌
   });
});