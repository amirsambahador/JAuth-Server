package org.j2os.jauth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.j2os.jauth.common.constant.DataBaseType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Role")
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    @Column(columnDefinition = DataBaseType.string256, unique = true, nullable = false)
    private String roleName;

}
