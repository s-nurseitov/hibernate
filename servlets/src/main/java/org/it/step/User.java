package org.it.step;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "USERS", schema = "IT_STEP")
public class User {
    @Id
    private long id;

    @Column(name = "USER", nullable = false)
    private String login;

    @Column(name="logged")
    private Timestamp loggedAt;

    @Transient
    private boolean notMapped;

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Timestamp getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(Timestamp loggedAt) {
        this.loggedAt = loggedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", loggedAt=" + DateFormat.getInstance().format(new Date(loggedAt.getTime())) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login);
    }
}
