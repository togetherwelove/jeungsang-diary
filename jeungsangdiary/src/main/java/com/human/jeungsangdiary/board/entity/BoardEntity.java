package com.human.jeungsangdiary.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.human.jeungsangdiary.board.vo.Board;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="boards")
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private int hit;

    public static BoardEntity toSaveEntity(Board boardVO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setUserId(boardVO.getUserId());
        boardEntity.setTitle(boardVO.getTitle());
        boardEntity.setContent(boardVO.getContent());
        boardEntity.setHit(0);

        return boardEntity;
    }
}

// Entity를 사용하는 이유

// 1.데이터베이스와의 매핑: 대부분의 애플리케이션은 데이터베이스와 상호작용해야 합니다. 
// Entity는 데이터베이스 테이블과 매핑되어 영속적인 저장 및 검색을 가능하게 합니다.

// 2.비즈니스 로직의 캡슐화: Entity는 비즈니스 도메인 개념을 표현하며, 해당 도메인에 
// 관련된 비즈니스 로직을 캡슐화할 수 있습니다. 이로 인해 코드의 가독성과 유지보수성이 향상됩니다.

// 3.객체 지향 설계 원칙 준수: Entity는 객체 지향 프로그래밍에서 중요한 개념입니다. 
// 엔티티 클래스는 속성과 메서드를 함께 묶어서 응집력 있는 객체 모델을 형성합니다.

// 4.확장성 및 유연성: Entity 클래스는 필요에 따라 추가적인 속성 및 동작을 포함시킬 수 있으며, 
// 관련된 기능을 확장하기 용이합니다.

// 5.재사용 가능한 코드: 엔티티 클래스는 여러 부분에서 재사용될 수 있습니다. 
// 예를 들어, 서비스 계층에서 여러 엔티티 객체들을 조합하여 복잡한 비즈니스 로직을 처리할 수 있습니다.

// 그러나 모든 프로젝트가 엔티티 개념을 필요로 하는 것은 아닙니다. 
// 간단한 스크립트나 작은 규모의 애플리케이션 등에서는 단순화된 구조로 데이터 처리가 가능할 수도 있습니다.
// 따라서 프로젝트의 크기, 복잡성, 요구사항 등을 고려하여 Entity 클래스 사용 여부를 결정해야 합니다.