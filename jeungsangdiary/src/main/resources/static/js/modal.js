

      if ($(e.target).hasClass("add-btn")) {
        let parentDiv = $(e.target).closest(".md-3");

        let newDiv = $("<div>", { class: "d-flex mt-1" });
        let newFileInput = $("<input>", { type: "file", class: "form-control img-file" });
        let newButtonInput = $("<input>", { type: "button", class: "btn btn-danger remove-btn ms-1", value: "삭제" });
        newDiv.append(newFileInput);
        newDiv.append(newButtonInput);
        parentDiv.append(newDiv);
      }

      if ($(e.target).hasClass("remove-btn")) {
        let parentDiv = $(e.target).parent();
        let index = $(".md-3 .d-flex.mt-1").index(parentDiv);

        if (index > 0) {
          $(e.target).parent().remove();
        } else {
          $(e.target).prev().val(null);
          $(e.target).prev().trigger("change");
        }
      }

      if ($(e.target).hasClass("export-btn")) {
        let startDate = $("#export-date-start").val();
        let endDate = $("#export-date-end").val();
        if (!this.validateDateField(startDate, "#export-date-start", "시작 날짜를 입력해주세요.")) {
          return;
        }
        if (!this.validateDateField(endDate, "#export-date-end", "끝 날짜를 입력해주세요.")) {
          return;
        }
      }
    });
  }
}
