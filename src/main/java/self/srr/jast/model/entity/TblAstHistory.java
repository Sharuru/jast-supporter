package self.srr.jast.model.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * History entity
 */
@Data
@Entity
@Table(name = "ast_history")
@EntityListeners(AuditingEntityListener.class)
public class TblAstHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "ast_history_id_seq")
    private Long id;

    @Column(name = "file_id")
    private Long fileId;

    @Column(name = "revision_id")
    private String revisionId;

    @Column(name = "operation_task")
    private String operationTask;

    private Long operator;

    @Column(name = "operation_time")
    @Temporal(TIMESTAMP)
    private Date operationTime;

    @Column(name = "created_at")
    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date updatedAt;

}
