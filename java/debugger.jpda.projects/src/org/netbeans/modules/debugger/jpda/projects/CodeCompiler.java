/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.debugger.jpda.projects;

import java.io.IOException;
import java.util.Map;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;
import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.api.java.source.JavaSource;
import org.netbeans.modules.java.preprocessorbridge.api.JavaSourceUtil;
import org.openide.filesystems.FileObject;

/**
 * Compiles changed Java source.
 * 
 * @author martin
 */
class CodeCompiler {
    
    static Map<String, byte[]> compile(FileObject fo, JavaSource js,
                                       String newSource,
                                       DiagnosticListener<? super JavaFileObject> diagnostics) throws IOException {
        ClassPath classPath = ClassPath.getClassPath(fo, ClassPath.SOURCE);
        if (classPath == null) {
            return null;
        }
        FileObject root = classPath.findOwnerRoot(fo);
        if (root == null) {
            return null;
        }
        return JavaSourceUtil.generate(root, fo, newSource, diagnostics);
    }
}
