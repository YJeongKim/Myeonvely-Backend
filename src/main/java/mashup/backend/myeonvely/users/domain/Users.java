package mashup.backend.myeonvely.users.domain;

import lombok.*;
import mashup.backend.myeonvely.common.domain.BaseTimeEntity;
import mashup.backend.myeonvely.items.domain.History;

import javax.persistence.*;
import java.util.List;

@Getter
@ToString(exclude = "devices")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Devices> devices;

    @Builder
    public Users(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public void setDevices(List<Devices> devices) {
        this.devices = devices;
    }

    public Users update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
