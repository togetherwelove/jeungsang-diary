/**
 * 알림창 띄우기
 * @param message 알림창에 띄울 메시지
 */
function showToast(message) {
  // Create toast element if it does not exist
  let toast = $("#toast");
  if (toast.length === 0) {
    toast = $("<div>", { class: "rounded", id: "toast" });
    $("body").append(toast);
  }

  // Show the message
  toast.attr("hidden", false);
  toast.text(message);

  // Hide the message after a delay
  setTimeout(function () {
    toast.attr("hidden", true);
  }, 3000);
}
