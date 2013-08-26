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

package org.dogtagpki.server.tps.token;

import java.util.Date;

import com.netscape.cmscore.dbs.Database;

/**
 * This class implements in-memory token database. In the future this
 * will be replaced with LDAP database.
 *
 * @author Endi S. Dewata
 */
public class TokenDatabase extends Database<TokenRecord> {

    public TokenDatabase() {
        super("Token");

        // add sample records
        try {
            TokenRecord record1 = new TokenRecord();
            record1.setID("token1");
            record1.setUserID("user1");
            record1.setStatus("ENABLED");
            addRecord(record1);

            TokenRecord record2 = new TokenRecord();
            record2.setID("token2");
            record2.setUserID("user2");
            record2.setStatus("DISABLED");
            addRecord(record2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRecord(TokenRecord tokenRecord) throws Exception {
        tokenRecord.setStatus("ENABLED");
        tokenRecord.setCreateTimestamp(new Date());

        addRecord(tokenRecord.getID(), tokenRecord);
    }

    public void updateRecord(TokenRecord tokenRecord) throws Exception {
        tokenRecord.setModifyTimestamp(new Date());

        updateRecord(tokenRecord.getID(), tokenRecord);
    }
}
