package org.j2os.jauth.entity;

import lombok.*;
import org.j2os.jauth.common.constant.DataBaseType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private Long creationTime;

    @Column(columnDefinition = DataBaseType.string32, unique = true, nullable = false)
    private String username;

    @Column(columnDefinition = DataBaseType.string128, unique = true)
    private String token;

    @Column(columnDefinition = DataBaseType.string128)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();

}
