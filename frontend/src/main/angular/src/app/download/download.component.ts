import {Component, OnInit} from '@angular/core';
import {PdfService} from '../pdf.service';
import {saveAs} from 'file-saver'

@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.css']
})
export class DownloadComponent implements OnInit {

  constructor(private pdfService: PdfService) {
  }

  ngOnInit() {

  }

  exportFile(texto: string) {
    // @ts-ignore
    this.pdfService.export(texto).subscribe(
      res =>
        this.downloadFile(res.body, res.headers.get('content-type')));
  }

  downloadFile(data: any, contentType: string | null) {
    const blob = new Blob([data], {type: contentType + '; charset=utf-8'});
    saveAs.saveAs(blob, 'prueba');
  }
}
