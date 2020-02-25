<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <html>
            <body  style="font-family: Arial; font-size: 16px; background-color: #EEE">
                <table border="1">
                    <tr style="background-color: green; weight: 100%; border-collapse: collapse">
                        <th rowspan="2">Module</th>
                        <th rowspan="2">Origin</th>
                        <th colspan="5">Chars</th>
                        <th colspan="3" >Parameters</th>
                        <th rowspan="2">Price</th>
                    </tr>
                    <tr style="background-color: blue">
                        <td>type</td>
                        <td>numberOfSeats</td>
                        <td>combatKit</td>
                        <td>rackets</td>
                        <td>availabilityOfRadar</td>
                        <td>length</td>
                        <td>width</td>
                        <td>height</td>
                    </tr>
                    <tr style="background-color: blue">

                    </tr>


                    <xsl:for-each select="Planes/Plane">
                        <tr>
                            <td><xsl:value-of select="model"/></td>
                            <td><xsl:value-of select="origin"/></td>
                            <td><xsl:value-of select="chars/typeOfPlane"/></td>
                            <td><xsl:value-of select="chars/numberOfSeats"/></td>
                            <td><xsl:value-of select="chars/combatKit"/></td>


                            <td><xsl:value-of select="chars/rackets"/></td>

                            <td><xsl:value-of select="chars/availabilityOfRadar"/></td>
                            <td><xsl:value-of select="parameters/length"/></td>
                            <td><xsl:value-of select="parameters/width"/></td>
                            <td><xsl:value-of select="parameters/height"/></td>
                            <td><xsl:value-of select="price"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

