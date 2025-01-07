--PL-SQL 이란 SQL 언어에 절차적 언어요소 추가해서 프로그래밍한 것을 PL/SQL 이라고 한다
-- 형식
-- DECLARE
-- 변수, 커서(객체) 선언
-- BEGIN
-- SQL 구문이나 PL/SQL 문으로 코딩
-- END
-- / (실행)

--스크립트 출력창에 결과가 출력되도록 한번만 설정
SET SERVEROUTPUT ON
SET SERVEROUTPUT OFF

--예제1
DECLARE
    V_NO NUMBER(4,1); --변수선언, 4자리 수 소숫점이하 1자리
BEGIN
    V_NO:=12.7; --값 대입(오라클에서 = -> 비교연산자, := 대입연산자)
    dbms_output.put_line(V_NO); --콘솔 창에 출력
END;
/ 
    
--DECLARE
--BEGIN
--    dbms_output.put_line(V_NO);
--END;

--예제2
DECLARE
    VCOLOR VARCHAR2(20);
    vprice NUMBER(20);
    vsangpum VARCHAR2(20);
BEGIN
    vcolor:='오렌지색';
    vprice:=35000;
    vsangpum:='모직코트';
    
    dbms_output.put_line('상품명 : '||vsangpum);
    dbms_output.put_line('가  격 : '||vprice||'원');
    dbms_output.put_line('색  상 : '||vcolor);
END;
/

--예제 3

DECLARE
    vscode VARCHAR2(20);
    vsprice NUMBER(20);
    vsangpum VARCHAR2(30);
BEGIN
   vscode:='A300';
   
   -- vscode 값에 해당하는 상품데이터 가져오기
   select sangprice, sangname
   into vsprice,vsangpum
   from shop
   where sangcode = vscode;
    
    dbms_output.put_line('상품명 : '||vsangpum);
    dbms_output.put_line('가  격 : '||vsprice||'원');
    dbms_output.put_line('코드번호 : '||vscode);
END;
/

--예제 3 - 년도에 따라서 띠를 구해보자

DECLARE
    v_year number(4) :=2025;
    v_mod number(2) :=mod(v_year,12);
    v_ddi varchar2(20);
BEGIN
    if v_mod = 0 then v_ddi := '원숭이띠';
    elsif v_mod = 1 then v_ddi := '닭띠';
    elsif v_mod = 2 then v_ddi := '개띠';
    elsif v_mod = 3 then v_ddi := '돼지띠';
    elsif v_mod = 4 then v_ddi := '쥐띠';
    elsif v_mod = 5 then v_ddi := '소띠';
    elsif v_mod = 6 then v_ddi := '호랑이띠';
    elsif v_mod = 7 then v_ddi := '토끼띠';
    elsif v_mod = 8 then v_ddi := '용띠';
    elsif v_mod = 9 then v_ddi := '뱀띠';
    elsif v_mod = 10 then v_ddi := '말띠';
    elsif v_mod = 11 then v_ddi := '양띠';
    end if;
    
    dbms_output.put_line(v_year||'년도는 '||v_ddi||'해이다');
END;
/

--accept를 이용해서 년도를 직접 입력해서 띠를 알아보자
accept year PROMPT '년도를 입력해주세요' --키보드로 값 입력받기
DECLARE
    v_year number(4) :='&year'; --입력받은 year값 가져오기
    v_mod number(2) :=mod(v_year,12);
    v_ddi varchar2(20);
BEGIN
    if v_mod = 0 then v_ddi := '원숭이띠';
    elsif v_mod = 1 then v_ddi := '닭띠';
    elsif v_mod = 2 then v_ddi := '개띠';
    elsif v_mod = 3 then v_ddi := '돼지띠';
    elsif v_mod = 4 then v_ddi := '쥐띠';
    elsif v_mod = 5 then v_ddi := '소띠';
    elsif v_mod = 6 then v_ddi := '호랑이띠';
    elsif v_mod = 7 then v_ddi := '토끼띠';
    elsif v_mod = 8 then v_ddi := '용띠';
    elsif v_mod = 9 then v_ddi := '뱀띠';
    elsif v_mod = 10 then v_ddi := '말띠';
    elsif v_mod = 11 then v_ddi := '양띠';
    end if;
    
    dbms_output.put_line(v_year||'년도는 '||v_ddi||'해이다');
END;
/

--예제4, 상품코드, 상품명, 가격을 입력받아 shop 테이블에 추가해보자

accept scode PROMPT 'A로 시작하는 상품코드를 입력';
accept ssang PROMPT '상품명 입력';
accept sprice PROMPT '가격을 입력하세요';

declare
    v_code varchar2(20) :='&scode';
    v_sang varchar2(30) :='&ssang';
    v_price number(10) :='&sprice';
begin
    insert into shop (sangcode, sangname, sangprice)
    values(v_code,v_sang,v_price);
    dbms_output.put_line(v_sang||' 상품정보를 테이블에 추가함');
end;
/

-- 예제 5 Cursor 와 for 문을 이용하여 shop의 데이터들을 읽어오자
declare
    --커서 객체에 select sql문을 이용해서 넣기
    CURSOR s1
    is
    select * from shop;
begin
    for s in s1 loop -- record 단위로 s가 가져온다
        dbms_output.put_line(s.sangcode||'   '||s.sangname||'     '||s.sangprice);
        exit when s1%notfound; -- 더 이상 데이터 없으면 for문 빠져나가라
    end loop;
end;
/  

--응용 : join sql문 이용 cartnum,sangcode,sangname,sangprice,cntnum,cartday 출력

  declare
    --커서 객체에 select sql문을 이용해서 넣기
    CURSOR s1
    is
    select
         c.cartnum,s.sangcode, S.SANGNAME, S.SANGPRICE,c.cntnum,
        TO_CHAR(CARTDAY,'YYYY-MM-DD HH24:MI') CARTDAY
        from shop s, cart c
        where s.sangcode = c.sangcode;
begin
    for s in s1 loop -- record 단위로 s가 가져온다
        dbms_output.put_line(s.cartnum||'   '||s.sangcode||'     '||s.sangname
        ||'     '||s.sangprice||'     '||s.cntnum||'     '||s.cartday);
        exit when s1%notfound; -- 더 이상 데이터 없으면 for문 빠져나가라
    end loop;
end;
/  
--상품코드와 상품명 가격을 accept을 이용해서 입력 후
--shop 에 해당 상품코드가 존재할 경우 update로 수정을 하고
--존재하지 않을 경우 insert로 추가하시오

accept scode PROMPT 'A로 시작하는 상품코드를 입력';
accept ssang PROMPT '상품명 입력';
accept sprice PROMPT '가격을 입력하세요';

declare
    v_code varchar2(20) :='&scode';
    v_sang varchar2(30) :='&ssang';
    v_price number(10) :='&sprice';
    v_cnt number(2); --count 값을 가져올 변수
    
    --커서객체에 select sql 문을 이용해서 넣기
begin
    select count(*) into v_cnt
    from shop where sangcode=v_code;
    --존재하면 1, 존재하지 않으면 0
    if v_cnt=1 then
        --update 처리
        update shop set sangname = v_sang,sangprice=v_price
        where sangcode=v_code;
        commit;
        dbms_output.put_line(v_code||' 상품이 수정되었습니다');
    else
        insert into shop(sangcode,sangname,sangprice)
        values(v_code,v_sang,v_price);
        commit;
        dbms_output.put_line(v_code||' 상품이 추가되었습니다');
    end if;

end;
/

--상품명을 입력하면 shop table에서 그 이름을 포함하고 있는 데이터들을 모두 출력

accept sangpum PROMPT '상품명 입력';

declare
    v_sangpum varchar2(30):= '&sangpum';
    cursor s1
    is
    select * from shop where sangname like '%'||v_sangpum||'%';
    v_cnt number(2);
    --커서객체에 select sql 문을 이용해서 넣기
begin
--입력한 상품명을 포함한 레코드 갯수 겟또
    select count(*) into v_cnt
    from shop where sangname like '%'||v_sangpum||'%';
    --존재하면 1, 존재하지 않으면 0
    if v_cnt=0 then
         dbms_output.put_line(v_sangpum||' 상품이 존재하지 않습니다');
        --update 처리
    else
        dbms_output.put_line('상품코드    상품명      상품가격');
        dbms_output.put_line('--------------------------------');
    for s in s1 loop
        dbms_output.put_line(s.sangcode||'        '||s.sangname||'        '||
                                s.sangprice);
        exit when s1%notfound;
        end loop;
    end if;

end;
/
    