package kr.co.sboard.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import kr.co.sboard.entity.FileEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDTO {

    private int fno;
    private int ano;
    private String ofile;
    private String sfile;
    private int download;
    private LocalDateTime rdate;

    public FileEntity toEntity() {

        return FileEntity.builder()
                .fno(fno)
                .ano(ano)
                .ofile(ofile)
                .sfile(sfile)
                .download(download)
                .rdate(rdate)
                .build();

    }

}
