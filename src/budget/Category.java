package budget;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Category category = (Category) o;

        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        return 31 * result;
    }
}
