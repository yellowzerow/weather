package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo newMemo = new Memo(10, "this is jpa memo");
        //when
        jpaMemoRepository.save(newMemo);
        //then

        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }


    @Test
    void findByIdTest() {
        /* 이상태로 하면 오류남! 왜냐하면 repository에서 id값을 자동생성하도록
        설정해두었기 때문이다! given에서 우리가 준 id 값은 의미없는 값
        given
        Memo newMemo = new Memo(11, "jpa");
        when
        jpaMemoRepository.save(newMemo);
        then
        Optional<Memo> result = jpaMemoRepository.findById(11);
        assertEquals(result.get().getText(), "jpa");
        */

        //given
        Memo newMemo = new Memo(11, "jpa");
        //when
        Memo memo = jpaMemoRepository.save(newMemo);
        //then
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
        assertEquals(result.get().getText(), "jpa");
    }
}