package pl.com.softproject.diabetyk.core.model;

import pl.com.softproject.diabetyk.core.enums.Role;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Class Authority
 *
 * @author Marcin Jasinski {@literal <mkjasinski@gmail.com>}
 */
@Entity
@Table(name = "authorities", schema = "public")
@IdClass(AuthorityId.class)
@SuppressWarnings("PersistenceUnitPresent")
public class Authority implements Serializable {

    @Id
    @Column(name = "username")
    @Size(max = 50)
    private String userName;

    @Id
    @Column
    @Enumerated(EnumType.STRING)
    private Role authority;

    public Authority() {

    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public Role getAuthority() {

        return authority;
    }

    public void setAuthority(Role authority) {

        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Authority authority1 = (Authority) o;

        return !(authority != null ? !authority.equals(authority1.authority)
                                   : authority1.authority != null) && !(userName != null ? !userName
                .equals(authority1.userName) : authority1.userName != null);
    }

    @Override
    public int hashCode() {

        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}
