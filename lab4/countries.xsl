<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0"
               xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
               xmlns="http://www.w3.org/1999/xhtml">
    <xsl:template match="/">
        <table width="100%" border="1">
            <tr bgcolor="#9acd32">
                <th onClick="orderByName();">Name</th>
                <th onClick="orderByPopulation();">Population</th>
                <th>Capital</th>
                <th>Polity</th>
                <th onClick="orderByFoundingDate();">Founding Date</th>
                <th>Area</th>
                <th>Area Units</th>
            </tr>
            <xsl:for-each select="countries/country">
                <tr>
                    <td><xsl:value-of select="@name"/></td>
                    <xsl:choose>
                        <xsl:when test="@population &gt; 50000000">
                            <td bgcolor="#befac8"><xsl:value-of select="@population"/></td>
                        </xsl:when>
                        <xsl:otherwise>
                            <td bgcolor="#fabec6"><xsl:value-of select="@population"/></td>
                        </xsl:otherwise>
                    </xsl:choose>
                    <td><xsl:value-of select="capital"/></td>
                    <td><xsl:value-of select="polity"/></td>
                    <td><xsl:value-of select="translate(foundingDate, '.', ' ')"/></td>
                    <td><xsl:value-of select="area"/></td>
                    <td><xsl:value-of select="area/@units"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>