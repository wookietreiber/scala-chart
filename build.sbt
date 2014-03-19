import scalax.chart.build._

import Dependencies._

lazy val chart = (
  ChartProject("scala-chart", ".")
  settings (
    autoAPIMappings := true,
    libraryDependencies ++= Seq(jfreechart, swing(scalaVersion.value)) ++ specs(scalaVersion.value),
    libraryDependencies += itext % Optional,
    scalacOptions in (Compile, doc) <++= (baseDirectory) map { bd =>
      Seq("-sourcepath", bd.getAbsolutePath, "-doc-source-url", docURL)
    }
  )
)
