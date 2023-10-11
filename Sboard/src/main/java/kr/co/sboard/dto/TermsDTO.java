package kr.co.sboard.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import kr.co.sboard.entity.TermsEntity;
import kr.co.sboard.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TermsDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String terms;
    private String privacy;

    // Entity 변환 메서드
    public TermsEntity toEntity() {

        return TermsEntity.builder()
                .no(no)
                .terms(terms)
                .privacy(privacy)
                .build();
    }
}
