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
// (C) 2013 Red Hat, Inc.
// All rights reserved.
// --- END COPYRIGHT BLOCK ---

package com.netscape.cmstools.tps.connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

import com.netscape.certsrv.tps.connection.ConnectionData;
import com.netscape.cmstools.cli.CLI;
import com.netscape.cmstools.cli.MainCLI;

/**
 * @author Endi S. Dewata
 */
public class ConnectionAddCLI extends CLI {

    public ConnectionCLI connectionCLI;

    public ConnectionAddCLI(ConnectionCLI connectionCLI) {
        super("add", "Add connection", connectionCLI);
        this.connectionCLI = connectionCLI;
    }

    public void printHelp() {
        formatter.printHelp(getFullName() + " <Connection ID> [OPTIONS...]", options);
    }

    public void execute(String[] args) throws Exception {

        Option option = new Option(null, "status", true, "Status: ENABLED, DISABLED.");
        option.setArgName("status");
        option.setRequired(true);
        options.addOption(option);

        option = new Option(null, "contents", true, "Input file containing connection attributes.");
        option.setArgName("file");
        option.setRequired(true);
        options.addOption(option);

        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            printHelp();
            System.exit(1);
        }

        String[] cmdArgs = cmd.getArgs();

        if (cmdArgs.length != 1) {
            printHelp();
            System.exit(1);
        }

        String connectionID = cmdArgs[0];
        String status = cmd.getOptionValue("status");
        String contents = cmd.getOptionValue("contents");

        ConnectionData connectionData = new ConnectionData();
        connectionData.setID(connectionID);
        connectionData.setStatus(status);

        if (contents != null) {
            try (BufferedReader in = new BufferedReader(new FileReader(contents));
                StringWriter sw = new StringWriter();
                PrintWriter out = new PrintWriter(sw, true)) {

                String line;
                while ((line = in.readLine()) != null) {
                    out.println(line);
                }

                connectionData.setContents(sw.toString());
            }
        }

        connectionData = connectionCLI.connectionClient.addConnection(connectionData);

        MainCLI.printMessage("Added connection \"" + connectionID + "\"");

        ConnectionCLI.printConnectionData(connectionData);
    }
}
