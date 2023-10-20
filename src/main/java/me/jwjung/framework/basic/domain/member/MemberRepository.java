package me.jwjung.framework.basic.domain.member;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong(0L);

    @Getter
    private static MemberRepository instance = new MemberRepository();

    public void save(Member member) {
        try {
            Class<Member> memberClass = Member.class;
            Field id = memberClass.getDeclaredField("id");
            id.setAccessible(true);
            id.set(member, sequence.incrementAndGet());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException("Reflection Exception", e);
        }

        //save member
        store.put(member.getId(), member);
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
