import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AgentsService } from './agents.service';

@Component({
  selector: 'app-agents',
  templateUrl: './agents.component.html',
  styleUrls: ['./agents.component.scss']
})
export class AgentsComponent implements OnInit {

  selectedFiles?: FileList;
  progressInfos: any[] = [];

  constructor(private agentsService: AgentsService) { }

  ngOnInit(): void {
  }

  selectFiles(event: any): void {
    this.progressInfos = [];
    this.selectedFiles = event.target.files;
    if (this.selectedFiles) {
      for (let i = 0; i < this.selectedFiles.length; i++) {
        this.progressInfos[i] = { value: 0, fileName: this.selectedFiles[i].name };
      }
    }
  }

  uploadFiles(): void {
    if (this.selectedFiles) {
      for (let i = 0; i < this.selectedFiles.length; i++) {
        let fileReader = new FileReader();
        let fileName = this.selectedFiles[i].name;
        fileReader.onload = (e) => {
          this.upload(i, this.sensitiveDataRemover(fileName, fileReader.result as string));
        }
        fileReader.readAsText(this.selectedFiles[i]);
      }
    }
  }

  private sensitiveDataRemover(name: string, content: string): File {

    var parser = new DOMParser();
    var xmldoc = parser.parseFromString(content,"text/xml");
    Array.from(xmldoc.querySelectorAll('precoMedio')).forEach(
      averagePriceNode => averagePriceNode?.querySelectorAll("valor")?.forEach(
        value => value.parentNode?.removeChild(value)
      )
    );
    var blob = new Blob([new XMLSerializer().serializeToString(xmldoc.documentElement)], { type: 'text/xml' });
    return new File([blob], name, {type: "text/plain"});
  }


  upload(idx: number, file: File): void {
    this.progressInfos[idx] = { value: 0, fileName: file.name, sucessMsg: '', failMsg: '' };
  
    if (file) {
      this.agentsService.upload(file).subscribe({
        next: (event: any) => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progressInfos[idx].value = Math.round(100 * event.loaded / event.total);
          } else if (event instanceof HttpResponse) {
            const msg = 'Upload realizado com sucesso: ' + file.name;
            this.progressInfos[idx].sucessMsg = msg;
          }
        },
        error: (err: any) => {
          this.progressInfos[idx].value = 0;
          const msg = 'Não foi possível fazer o uploado do arquivo: ' + file.name;
          this.progressInfos[idx].failMsg = msg;
        }
      });
    }
  }

}
