/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                               *
 *  Copyright © 2012-2013 Christian Krause                                                       *
 *                                                                                               *
 *  Christian Krause <kizkizzbangbang@googlemail.com>                                            *
 *                                                                                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                               *
 *  This file is part of 'scala-chart'.                                                          *
 *                                                                                               *
 *  This project is free software: you can redistribute it and/or modify it under the terms      *
 *  of the GNU Lesser General Public License as published by the Free Software Foundation,       *
 *  either version 3 of the License, or any later version.                                       *
 *                                                                                               *
 *  This project is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;    *
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.    *
 *  See the GNU Lesser General Public License for more details.                                  *
 *                                                                                               *
 *  You should have received a copy of the GNU Lesser General Public License along with this     *
 *  project. If not, see <http://www.gnu.org/licenses/>.                                         *
 *                                                                                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


package scalax.chart

import java.io._

import org.jfree.chart.ChartUtilities

import com.lowagie.text.pdf.{ DefaultFontMapper, FontMapper }

/** Provides methods for saving a chart.
  *
  * @define output the output file
  */
trait StorableChart extends WritableChart {

  self: Chart[_] ⇒

  /** Saves the chart as a JPEG image.
    *
    * @param output $output
    * @param dim    $dim
    */
  def saveAsJPEG(output: File, dim: (Int,Int)) {
    val (width,height) = dim
    ChartUtilities.saveChartAsJPEG(output, peer, width, height)
  }

  /** Saves the chart as a PDF.
    *
    * @param output     $output
    * @param dim        $dim
    * @param fontMapper $fontMapper
    */
  def saveAsPDF(output: File, dim: (Int,Int), fontMapper: FontMapper = new DefaultFontMapper) {
    val os = new BufferedOutputStream(new FileOutputStream(output))

    try {
      writeAsPDF(os, dim, fontMapper)
    } finally {
      os.close()
    }
  }

  /** Saves the chart as a PNG image.
    *
    * @param output $output
    * @param dim    $dim
    */
  def saveAsPNG(output: File, dim: (Int,Int)) {
    val (width,height) = dim
    ChartUtilities.saveChartAsPNG(output, peer, width, height)
  }

}
