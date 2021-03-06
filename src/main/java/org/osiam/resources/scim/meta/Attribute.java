/*
 * Copyright (C) 2013 tarent AG
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.osiam.resources.scim.meta;

import java.lang.reflect.Field;

import org.osiam.resources.exception.SCIMException;

public class Attribute<O, T> {

    private final String name;
    private final Field field;
    private final Class<O> ownerClazz;  // NOSONAR : not finished yet
    private final Class<T> typeClazz;  // NOSONAR : not finished yet

    public Attribute(String name, Class<O> ownerClazz, Class<T> typeClazz) {
        this.name = name;
        this.ownerClazz = ownerClazz;// NOSONAR : not finished yet
        this.typeClazz = typeClazz;// NOSONAR : not finished yet

        try {
            this.field = ownerClazz.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            throw new SCIMException("Cannot initialize meta model attribute " + name + " for class "
                    + ownerClazz.getSimpleName(), e);
        }
    }

    public String getName() {
        return name;
    }

    public Field getField() {
        return field;
    }
}