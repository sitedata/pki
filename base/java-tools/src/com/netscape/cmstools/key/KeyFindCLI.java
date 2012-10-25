// --- BEGIN COPYRIGHT BLOCK ---
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; version 2 of the License.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License along
// with this program; if not, write to the Free Software Foundation, Inc.,
// 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
//
// (C) 2012 Red Hat, Inc.
// All rights reserved.
// --- END COPYRIGHT BLOCK ---

package com.netscape.cmstools.key;

import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;

import com.netscape.certsrv.key.KeyDataInfo;
import com.netscape.certsrv.key.KeyDataInfos;
import com.netscape.cmstools.cli.CLI;
import com.netscape.cmstools.cli.MainCLI;

/**
 * @author Endi S. Dewata
 */
public class KeyFindCLI extends CLI {

    public KeyCLI parent;

    public KeyFindCLI(KeyCLI parent) {
        super("find", "Find keys");
        this.parent = parent;
    }

    public void printHelp() {
        formatter.printHelp(parent.name + "-" + name + " [OPTIONS...]", options);
    }

    public void execute(String[] args) {

        Option option = new Option(null, "client", true, "Client ID");
        option.setArgName("client ID");
        options.addOption(option);

        option = new Option(null, "status", true, "Status");
        option.setArgName("status");
        options.addOption(option);

        option = new Option(null, "maxResults", true, "Maximum results");
        option.setArgName("max results");
        options.addOption(option);

        option = new Option(null, "maxTime", true, "Maximum time");
        option.setArgName("max time");
        options.addOption(option);

        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);

        } catch (ParseException e) {
            System.err.println("Error: " + e.getMessage());
            printHelp();
            System.exit(1);
        }

        String clientID = cmd.getOptionValue("client");
        String status = cmd.getOptionValue("status");

        String s = cmd.getOptionValue("maxResults");
        Integer maxResults = s == null ? null : Integer.valueOf(s);

        s = cmd.getOptionValue("maxTime");
        Integer maxTime = s == null ? null : Integer.valueOf(s);

        KeyDataInfos keys = parent.keyClient.findKeys(clientID, status, maxResults, maxTime);

        Collection<KeyDataInfo> entries = keys.getKeyInfos();

        MainCLI.printMessage(entries.size() + " key(s) matched");

        boolean first = true;

        for (KeyDataInfo info : entries) {

            if (first) {
                first = false;
            } else {
                System.out.println();
            }

            KeyCLI.printKeyInfo(info);
        }

        MainCLI.printMessage("Number of entries returned " + entries.size());
    }
}
