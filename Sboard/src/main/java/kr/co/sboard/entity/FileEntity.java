package kr.co.sboard.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import kr.co.sboard.dto.FileDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="File")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;
    private int ano;
    private String ofile;
    private String sfile;
    private int download;
    @CreationTimestamp
    private LocalDateTime rdate;

    public FileDTO toDTO() {

        return FileDTO.builder()
                .fno(fno)
                .ano(ano)
                .ofile(ofile)
                .sfile(sfile)
                .download(download)
                .rdate(rdate)
                .build();

    }

}
