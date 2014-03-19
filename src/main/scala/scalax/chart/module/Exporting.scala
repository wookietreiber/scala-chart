package scalax.chart
package module

import language.implicitConversions

import exporting._

/** $ExportingInfo */
object Exporting extends Exporting

/** $ExportingInfo
  *
  * @define ExportingInfo Charts may be exported into the following formats:
  *
  *  - JPEG
  *  - PNG
  *  - PDF
  *
  * There are different ways in which charts may be exported: encoding, writing and the actual
  * saving of the file, which is demonstrated by the following code snippet:
  *
  * {{{
  * val bytes = chart.encodeAsPNG()
  *
  * chart.writeAsPNG(System.out)
  *
  * chart.saveAsPNG("/tmp/chart.png")
  * }}}
  */
trait Exporting {

  implicit def ChartJPEGExporter(chart: Chart) =
    new JPEGExporter(chart)

  implicit def ChartPDFExporter(chart: Chart) =
    new PDFExporter(chart)

  implicit def ChartPNGExporter(chart: Chart) =
    new PNGExporter(chart)

}
