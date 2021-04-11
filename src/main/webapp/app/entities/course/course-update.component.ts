import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { ICourse, Course } from 'app/shared/model/course.model';
import { CourseService } from './course.service';
import { IPanier } from 'app/shared/model/panier.model';
import { PanierService } from 'app/entities/panier/panier.service';

@Component({
  selector: 'jhi-course-update',
  templateUrl: './course-update.component.html',
})
export class CourseUpdateComponent implements OnInit {
  isSaving = false;
  paniers: IPanier[] = [];

  editForm = this.fb.group({
    id: [],
    timeRequired: [null, [Validators.required]],
    panier: [],
  });

  constructor(
    protected courseService: CourseService,
    protected panierService: PanierService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ course }) => {
      this.updateForm(course);

      this.panierService
        .query({ filter: 'course-is-null' })
        .pipe(
          map((res: HttpResponse<IPanier[]>) => {
            return res.body || [];
          })
        )
        .subscribe((resBody: IPanier[]) => {
          if (!course.panier || !course.panier.id) {
            this.paniers = resBody;
          } else {
            this.panierService
              .find(course.panier.id)
              .pipe(
                map((subRes: HttpResponse<IPanier>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: IPanier[]) => (this.paniers = concatRes));
          }
        });
    });
  }

  updateForm(course: ICourse): void {
    this.editForm.patchValue({
      id: course.id,
      timeRequired: course.timeRequired,
      panier: course.panier,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const course = this.createFromForm();
    if (course.id !== undefined) {
      this.subscribeToSaveResponse(this.courseService.update(course));
    } else {
      this.subscribeToSaveResponse(this.courseService.create(course));
    }
  }

  private createFromForm(): ICourse {
    return {
      ...new Course(),
      id: this.editForm.get(['id'])!.value,
      timeRequired: this.editForm.get(['timeRequired'])!.value,
      panier: this.editForm.get(['panier'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICourse>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IPanier): any {
    return item.id;
  }
}
