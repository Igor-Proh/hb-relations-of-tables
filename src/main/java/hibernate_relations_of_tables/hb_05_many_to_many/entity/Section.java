package hibernate_relations_of_tables.hb_05_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH
            , CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            // название таблицы, которая выполняет роль Join Table
            name = "child_section"
            // столбец таблицы Join Table, который ссылается на PK source таблици
            , joinColumns = @JoinColumn(name = "section_id")
            // столбец таблицы Join Table, который ссылается на PK target таблици
            , inverseJoinColumns = @JoinColumn(name = "child_id")) //
    private List<Child> children;

    public Section() {
    }

    public Section(String name) {

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public void addChildToSection(Child child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
