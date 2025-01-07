SELECT
    s.sangcode,sangname,sangprice,cntnum,to_char(cartday,'yyyy-mm-dd') cartday
from shop s,cart c
where s.sangcode=c.sangcode;

