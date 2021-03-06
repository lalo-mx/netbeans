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
package org.netbeans.modules.apisupport.project.ui.customizer;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;

final class ClusterizeVisualPanel1 extends JPanel {
    private final ClusterizeWizardPanel1 panel;
    private ProgressHandle handle;

    ClusterizeVisualPanel1(ClusterizeWizardPanel1 aThis) {
        panel = aThis;
        handle = ProgressHandleFactory.createHandle(java.util.ResourceBundle.getBundle("org/netbeans/modules/apisupport/project/ui/customizer/Bundle").getString("MSG_ClusterizeScanning"));
        initComponents();
        progressPanel.add(BorderLayout.CENTER, ProgressHandleFactory.createProgressComponent(handle));
        progressName.add(BorderLayout.CENTER, ProgressHandleFactory.createMainLabelComponent(handle));
        putClientProperty("WizardPanel_contentSelectedIndex", Integer.valueOf(0)); // NOI18N
        putClientProperty("WizardPanel_contentData", panel.settings.getSteps()); // NOI18N
        putClientProperty("WizardPanel_autoWizardStyle", Boolean.TRUE); // NOI18N
        putClientProperty("WizardPanel_contentDisplayed", Boolean.TRUE); // NOI18N
        putClientProperty("WizardPanel_contentNumbered", Boolean.TRUE); // NOI18N
    }

    @Override
    public String getName() {
        if (panel == null || panel.settings == null) {
            return "";
        }
        return panel.settings.getStep(0);
    }

    void showProgress() {
        handle.start();
        progressPanel.setVisible(true);
    }
    void hideProgress() {
        progressPanel.setVisible(false);
        progressPanel.removeAll();
    }

    private String dirName() {
        int l = panel.settings.file.getPath().length();
        if (l > 30) {
            return "..." + panel.settings.file.getPath().substring(l - 30);
        }
        return panel.settings.file.getPath();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        warningPanel = new javax.swing.JLabel();
        progressPanel = new javax.swing.JPanel();
        progressName = new javax.swing.JPanel();

        org.openide.awt.Mnemonics.setLocalizedText(warningPanel, org.openide.util.NbBundle.getMessage(ClusterizeVisualPanel1.class, "MSG_NotValidCluster", dirName()));
        warningPanel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        progressPanel.setLayout(new java.awt.BorderLayout());

        progressName.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warningPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(progressName, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(progressPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(warningPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel progressName;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JLabel warningPanel;
    // End of variables declaration//GEN-END:variables
}

