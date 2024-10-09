package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.stereotype.Repository;

import static org.example.expert.domain.todo.entity.QTodo.todo;


@Repository
@RequiredArgsConstructor
public class TodoQueryRepositoryImpl implements TodoQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Todo findByIdWithUserQueryDsl(long todoId) {
        return jpaQueryFactory.selectFrom(todo).join(todo.user).fetchJoin().where(todo.id.eq(todoId)).fetchOne();

    }
}
