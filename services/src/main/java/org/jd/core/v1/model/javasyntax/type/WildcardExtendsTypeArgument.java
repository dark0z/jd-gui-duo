/*
 * Copyright (c) 2008, 2019 Emmanuel Dupuy.
 * This project is distributed under the GPLv3 license.
 * This is a Copyleft license that gives the user the right to use,
 * copy and modify the code freely for non-commercial purposes.
 */

package org.jd.core.v1.model.javasyntax.type;

import java.util.Map;
import java.util.Objects;

public record WildcardExtendsTypeArgument(Type type) implements TypeArgument {

    @Override
    public boolean isTypeArgumentAssignableFrom(Map<String, BaseType> typeBounds, BaseTypeArgument typeArgument) {
        if (typeArgument.isWildcardExtendsTypeArgument()) {
            return type.isTypeArgumentAssignableFrom(typeBounds, typeArgument.type());
        }
        if (typeArgument instanceof Type) {
            return type.isTypeArgumentAssignableFrom(typeBounds, typeArgument);
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WildcardExtendsTypeArgument that = (WildcardExtendsTypeArgument) o;

        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return 957_014_778 + Objects.hash(type);
    }

    @Override
    public boolean isWildcardExtendsTypeArgument() { return true; }

    @Override
    public void accept(TypeArgumentVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "WildcardExtendsTypeArgument{? extends " + type + "}";
    }
}
