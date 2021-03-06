/*
 * Copyright (C) 2014 tarent AG
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

package org.osiam.resources.scim

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Ignore
import spock.lang.Specification

class NameJsonSpec extends Specification {

    private final static ObjectMapper mapper = new ObjectMapper()

    @Ignore('''We cannot use JSONAssert anymore, because of licensing issues. This
            test has to be re-activated when:

              1) JSONAssert fixes its licensing issues (see https://github.com/skyscreamer/JSONassert/issues/44)
              2) An alternative library for comparing JSON has been found

            Beware of the following: Whenever you change things in this project
            that might affect the generated JSON you HAVE TO re-activate this
            test, either using method 1), 2), or implementing an own JSON
            test mechanism!''')
    def 'isEmpty method should not be serialized to a field called empty'() {
        given:
        def name = new Name.Builder().build()

        when:
        def json = mapper.writeValueAsString(name)

        then:
        false
    }

}
